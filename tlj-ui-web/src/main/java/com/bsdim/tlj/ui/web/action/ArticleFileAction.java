package com.bsdim.tlj.ui.web.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.bsdim.tlj.api.exception.TLJRuntimeException;
import com.bsdim.tlj.domain.article.Article;
import com.bsdim.tlj.service.article.ArticleService;
import com.bsdim.tlj.ui.web.parser.DOMHandler;
import com.bsdim.tlj.ui.web.parser.DOMPars;
import com.bsdim.tlj.ui.web.servlet.Action;
import com.bsdim.tlj.ui.web.session.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * The article file.
 * <p>
 * Date: 2018-01-06
 *
 * @author Dzmitry Basiachenka
 */
public class ArticleFileAction implements Action {
    private static final String USER_SESSION = "userSession";
    private static final String FILE_NOT_VALID = "fileNotValid";
    private static final String MESSAGE_FILE_NOT_VALID = "The file is not valid";
    private static final String FILE_FORM = "file";
    private static final String SCHEME_XSD = "/scheme.xsd";
    private static final Validator VALIDATOR = getValidator();

    private static Logger sLogger = LoggerFactory.getLogger(ArticleFileAction.class);

    private static Validator getValidator() {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        String schemePath = ArticleFileAction.class.getResource(SCHEME_XSD).getPath();
        File schemaLocation = new File(schemePath);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            return schema.newValidator();
        } catch (SAXException e) {
            sLogger.error("Get validator");
            throw new TLJRuntimeException(e);
        }
    }

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Article article = getArticle(req);
            HttpSession session = req.getSession();
            UserSession user = (UserSession) session.getAttribute(USER_SESSION);

            article.setUserId(user.getId());
            article.setId(UUID.randomUUID().toString());

            ArticleService articleService = new ArticleService();
            articleService.create(article);
        } catch (TLJRuntimeException e) {
            req.setAttribute(FILE_NOT_VALID, MESSAGE_FILE_NOT_VALID);
        }
        return new MainAction().perform(req, resp);
    }

    private Article getArticle(HttpServletRequest req) {
        InputStream fileContent = getInputStreamUploadedFile(req);
        Document document = new DOMPars().parse(fileContent);
        Source source = new DOMSource(document);
        try {
            VALIDATOR.validate(source);
            return new DOMHandler().process(document);
        } catch (SAXException | IOException e) {
            sLogger.warn("Get article");
            throw new TLJRuntimeException(e);
        }
    }

    private static InputStream getInputStreamUploadedFile(HttpServletRequest req) {
        try {
            Part filePart = req.getPart(FILE_FORM);
            return filePart.getInputStream();
        }  catch (IOException | ServletException  e) {
            sLogger.error("Get input stream");
            throw new TLJRuntimeException(e);
        }
    }
}

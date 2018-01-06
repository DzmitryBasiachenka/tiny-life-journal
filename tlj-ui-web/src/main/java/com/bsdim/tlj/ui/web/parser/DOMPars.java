package com.bsdim.tlj.ui.web.parser;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.bsdim.tlj.api.exception.TLJRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * The DOM parser.
 * <p>
 * Date: 2018-01-06
 *
 * @author Dzmitry Basiachenka
 */
public class DOMPars {
    private static Logger sLogger = LoggerFactory.getLogger(DOMPars.class);

    /**
     * Parses the document.
     *
     * @param fileContent the fileContent.
     * @return the article.
     */
    public Document parse(InputStream fileContent) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            return documentBuilder.parse(fileContent);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            sLogger.error("Parse");
            throw new TLJRuntimeException(e);
        }
    }
}

package com.bsdim.tlj.ui.web.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsdim.tlj.ui.web.info.InfoBlock;
import com.bsdim.tlj.ui.web.servlet.Action;

/**
 * The communication action.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class CommunicationAction implements Action {
    private static final String COMMUNICATION_JSP_NAME = "communication.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("blocks", addImageInfo());
        return COMMUNICATION_JSP_NAME;
    }

    /**
     * Adds image info.
     *
     * @return the list of info blocks.
     */
    public List<InfoBlock> addImageInfo() {
        List<InfoBlock> list = new ArrayList<>();

        InfoBlock info1 = new InfoBlock();
        InfoBlock info2 = new InfoBlock();
        InfoBlock info3 = new InfoBlock();

        info1.setImageUrl("programmer");
        info1.setTitle("programmer");

        info2.setImageUrl("sun");
        info2.setTitle("sun");

        info3.setImageUrl("moon");
        info3.setTitle("moon");

        list.add(info1);
        list.add(info2);
        list.add(info3);

        return list;
    }
}

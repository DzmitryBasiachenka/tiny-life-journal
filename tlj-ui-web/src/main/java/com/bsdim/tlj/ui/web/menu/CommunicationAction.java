package com.bsdim.tlj.ui.web.menu;

import com.bsdim.tlj.ui.web.info.InfoBlock;
import com.bsdim.tlj.ui.web.servlet.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CommunicationAction implements Action {
    private String jspName = "communication.jsp";

    @Override
    public String perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("blocks", addImageInfo());
        return jspName;
    }

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

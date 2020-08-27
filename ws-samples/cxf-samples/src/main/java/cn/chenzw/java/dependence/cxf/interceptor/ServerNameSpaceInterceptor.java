package cn.chenzw.java.dependence.cxf.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.model.ServiceInfo;

/**
 * @author chenzw
 */
public class ServerNameSpaceInterceptor extends AbstractPhaseInterceptor<Message> {

    public ServerNameSpaceInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        for (ServiceInfo si : message.getExchange().getService().getServiceInfos()) {
            // 忽略掉命名空间（无命名空间）
            si.setProperty("soap.force.doclit.bare", true);
        }
    }
}
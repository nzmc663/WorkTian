package tianzefa.work.agentmain;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

/**
 * @author tzf 2020/11/12
 */
public class EcologyMain {

    private static String path1 ="/usr/weaver/ecologyagent.jar";

    private static String path2 ="/Users/tianjiao/Documents/workspace/git/WorkTian/ecology-agent/target/ecologyagent.jar";

    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        if (args!=null&&args.length>0){
            System.out.println(args[0]);
            VirtualMachine attach = VirtualMachine.attach(args[0]);
            attach.loadAgent(path2);
            System.out.println("attach成功");
            attach.detach();
            return;
        }
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd: list) {
//            if (vmd.displayName().startsWith("com.caucho.server.resin.Resin")){
            if (vmd.displayName().indexOf("MainTest")>-1){
                VirtualMachine attach = VirtualMachine.attach(vmd.id());
                attach.loadAgent(path2);
                System.out.println("attach成功");
                attach.detach();
            }
        }
    }
}

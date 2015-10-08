/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz;

import andras.szerviz.beans.AuthenticationFacadeRemote;
import andras.szerviz.beans.AutoFacadeRemote;
import andras.szerviz.beans.DolgozoFacadeRemote;
import andras.szerviz.beans.MarkaFacadeRemote;
import andras.szerviz.beans.MunkaFacadeRemote;
import andras.szerviz.beans.MunkaLOGFacadeRemote;
import andras.szerviz.beans.UgyfelFacadeRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Andras
 */
public class ClientUtil {
    
    private static final String appName = "andras-szerviz-eapp-ear-1.0-SNAPSHOT";
    private static final String moduleName = "andras-szerviz-eapp-ejb-1.0-SNAPSHOT";
    
    public static AutoFacadeRemote getAutoFacade() throws NamingException {
        return lookupStatelessEJB(AutoFacadeRemote.class, appName, moduleName, "AutoFacade");
    }
    
    public static DolgozoFacadeRemote getDolgozoFacade() throws NamingException {
        return lookupStatelessEJB(DolgozoFacadeRemote.class, appName, moduleName, "DolgozoFacade");
    }
    
    public static MarkaFacadeRemote getMarkaFacade() throws NamingException {
        return lookupStatelessEJB(MarkaFacadeRemote.class, appName, moduleName, "MarkaFacade");
    }   
    
    public static MunkaFacadeRemote getMunkaFacade() throws NamingException {
        return lookupStatelessEJB(MunkaFacadeRemote.class, appName, moduleName, "MunkaFacade");
    }    
    
    public static MunkaLOGFacadeRemote getMunkaLOGFacade() throws NamingException {
        return lookupStatelessEJB(MunkaLOGFacadeRemote.class, appName, moduleName, "MunkaLOGFacade");
    }    
    
    public static UgyfelFacadeRemote getUgyfelFacade() throws NamingException {
        return lookupStatelessEJB(UgyfelFacadeRemote.class, appName, moduleName, "UgyfelFacade");
    }    
    
    public static AuthenticationFacadeRemote getAuthenticationFacade() throws NamingException {
        return lookupEJB(AuthenticationFacadeRemote.class, appName, moduleName, "AuthenticationFacade", true);
    }        
    
    public static <T> T lookupStatelessEJB(Class<T> type, String appName, String moduleName, String beanName) throws NamingException {
        return lookupEJB(type, appName, moduleName, beanName, false);
    }
    
    public static <T> T lookupEJB(Class<T> type, String appName, String moduleName, String beanName, boolean stateful) throws NamingException {
        final Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        String s = "ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + type.getName() + (stateful ? "?stateful" : "");
        return (T) context.lookup(s);
    }    
}

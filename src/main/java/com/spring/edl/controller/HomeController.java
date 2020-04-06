package com.spring.edl.controller;
import java.security.Principal;
import com.spring.edl.model.Usuario;
import com.spring.edl.repository.UsuarioRepository;
import com.spring.edl.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;


/**
 *
 * @author dialv
 */
@Controller
public class HomeController extends UtilsController{
//   @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
    private UsuarioService usuarioService;
    
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @Autowired
    BCryptPasswordEncoder paswordEnc; 
    
    
    @Autowired 
    UsuarioRepository usr;
    
    
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "Bienvenido");
        return "index";
    }
  @RequestMapping(value = "usuarioconfirm")
    public String usuarioconfirm(Usuario usuario1,Model model, SessionStatus status) {
        try{
            
        Usuario usuario = usuarioService.getUsuarioById(usuario1.getCodigousuario()).get();
        usuario.setControlcontrasenia("0");
        usuario.setContraseniausuario(paswordEnc.encode(usuario1.getContraseniausuario()));
        usuarioService.saveUsuario(usuario);
        status.setComplete();
//         bitacoraService.BitacoraRegistry("se Creo un Usuario",getRequest().getRemoteAddr(), 
//                getRequest().getUserPrincipal().getName());//COBTROLARA EVENTO DE LA BITACORA
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
        return "index";
       // return "redirect:./show/" + usuario.getCodigousuario();
    }
   
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
         return "loginPage";
    }
 
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String homePage(Model model, Principal principal) {
        Usuario loginedUser = usr.findbyusername(principal.getName());
        model.addAttribute("usuario", loginedUser);
        model.addAttribute("messageuser", "Usuario :" + principal.getName());
        return ("1".equals(loginedUser.getControlcontrasenia()))?"passform":"indexorigen";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "loginPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hola " + principal.getName() //
            + "<br> Tu no cuentas con los permisos para acceder a esta pagina por favor consulta con tu administrador!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }
}

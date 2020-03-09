package com.spring.puebla.controller.usuariorol;

import com.spring.puebla.model.Usuariorol;
import com.spring.puebla.model.UsuariorolPK;
import com.spring.puebla.service.RolService;
import com.spring.puebla.service.UsuarioRolService;
import com.spring.puebla.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author root
 */
@Controller
@RequestMapping(value = "usuariosroles")

public class UsuarioRolController {

    private UsuarioRolService usuariorolService;
    
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    public void setUsuarioService(UsuarioRolService usuarioRolService) {
        this.usuariorolService = usuarioRolService;
    }
    
    private final String PREFIX = "fragments/usuariorol/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        
        model.addAttribute("usuariorols", usuariorolService.listAllUsuariosrol());
        return PREFIX + "usuariosrol";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("usuariorol", usuariorolService.getUsuariorolById(id));
        return PREFIX + "usuariorolform";
    }

    @RequestMapping("new/usuariorol")
    public String newUsuario(Model model) {
        UsuarioRolform form = new UsuarioRolform();
        form.setRoles(rolService.listAllRoles());
        form.setUsuarios(usuarioService.listAllUsuarios());
        form.setUsuariorol(new Usuariorol());
        model.addAttribute("formusuariorol", form);
        return PREFIX + "usuariorolform";
    }

    @RequestMapping(value = "usuariorol")
    public String saveUsuario(Usuariorol usuariorol,Model model) {
        try{
        UsuariorolPK llave = new UsuariorolPK();
        llave.setCodigorol(usuariorol.getRol().getCodigorol());
        llave.setCodigousuario(usuariorol.getUsuario().getCodigousuario());
        usuariorol.setUsuariorolPK(llave);
        usuariorolService.saveUsuariorol(usuariorol);
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
        UsuarioRolform form = new UsuarioRolform();
        form.setRoles(rolService.listAllRoles());
        form.setUsuarios(usuarioService.listAllUsuarios());
        form.setUsuariorol(new Usuariorol());
        model.addAttribute("formusuariorol", form);
        return PREFIX + "usuariorolform";

       // return "redirect:./show/" + usuariorol.getCodigousuariorol();
    }
    
    @RequestMapping("show/{id}")
    public String showUsuario(@PathVariable Integer id, Model model) {
        model.addAttribute("usuariorol", usuariorolService.getUsuariorolById(id).get());
        return PREFIX +"usuariorolshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
        usuariorolService.deleteUsuariorol(id);
         model.addAttribute("msg", 3);}
        
        catch(Exception e){
        model.addAttribute("msg", 4);
        }
        return PREFIX + "usuariosrol";
       // return "redirect:/usuariorols/";
    }
};

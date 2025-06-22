package com.example.Cagero_Automatico.Controller;

import com.example.Cagero_Automatico.ML.Efectivo;
import com.example.Cagero_Automatico.ML.Result;
import com.example.Cagero_Automatico.ML.Rol;
import com.example.Cagero_Automatico.ML.Usuario;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Cagero")
public class UsuarioController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public String Cagero(Model model) {
    return "Retiro";  // El nombre debe coincidir con tu archivo Thymeleaf (Cagero.html)
}
@GetMapping("/Usuarios")
    public String index(Model model) {
        String url = "http://localhost:8081/Usuario";

        ResponseEntity<Result<List<Usuario>>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result<List<Usuario>>>() {
        }
        );

        Result<List<Usuario>> response = responseEntity.getBody();

        List<Usuario> usuarios = new ArrayList<>();
        if (response != null && response.object != null) {
            usuarios = response.object;
        }

        Usuario usuarioBusqueda = new Usuario();
        usuarioBusqueda.Rol = new Rol();

        model.addAttribute("usuariosBusqueda", usuarioBusqueda);
        model.addAttribute("listaUsuarios", usuarios);

        return "Cagero";  // El nombre debe coincidir con tu archivo Thymeleaf (Cagero.html)
    }

    @GetMapping("/Efectivo")
    public String Efectivo(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Result<List<Efectivo>>> responseEntity = restTemplate.exchange(
                "http://localhost:8081/Efectivoapi",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result<List<Efectivo>>>() {
        });

        Result<List<Efectivo>> response = responseEntity.getBody();

        // ⚠️ Aquí adaptamos: si `objects` está vacío pero `object` contiene una lista, usamos `object`
        List<Efectivo> lista = response.object != null ? response.object : List.of();

        model.addAttribute("listaefectivos", lista);

        return "Efectivo";
    }

}

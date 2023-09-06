package init.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ping")
public class PruebaController {

    @GetMapping
    public ResponseEntity<Map<String, String>> ping(){
        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("saludo", "pong");
        return new ResponseEntity<>(mensaje, HttpStatus.ACCEPTED);
    }

}

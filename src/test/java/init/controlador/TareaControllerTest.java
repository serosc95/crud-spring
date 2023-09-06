package init.controlador;

import init.datos.DatosDummy;
import init.entidades.Tarea;
import init.servicios.contratos.TareaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TareaControllerTest {

    @InjectMocks
    private TareaController tareaController;

    @Mock
    private TareaDAO tareaDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() throws IOException {

        Tarea tarea = DatosDummy.tarea01();
        when(tareaDAO.findById(1)).thenReturn(Optional.of(tarea));

        ResponseEntity<?> response = tareaController.getById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(tarea, response.getBody());
    }

}
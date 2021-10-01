import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MemoriceThreadTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }/*Este método es ejecutado sólo una vez, después de haber finalizado todas las
    pruebas. Utilizado para limpiar elementos usados durante todas las ejecuciones, como
    por ejemplo desconectarse de un bd o similar.*/
    @Before
    public void setUp(){

    }/*Este método es ejecutado antes de cada prueba(@Test). Es usado para preparar el
    entorno de pruebas.*/

    @After
    public void setDown(){

    }/*El método es ejecutado después de cada prueba(@Test). Es usado para limpiar el
    entorno de prueba.*/



    @Test
    void crearPersona() {
    }

    @Test
    void arregloMxN() {
    }
}
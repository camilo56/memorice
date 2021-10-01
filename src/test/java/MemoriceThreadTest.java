
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemoriceThreadTest {

    MemoriceThread memorice = new MemoriceThread();

    @Test
    public void testCrearPersona(){
        assertEquals(true,memorice.crearPersona());
    }
}
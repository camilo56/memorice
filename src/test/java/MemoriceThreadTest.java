
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemoriceThreadTest {

    Memorice memorice = new Memorice();

    @Test
    public void testCrearPersona(){

        int num=3;
        int nVeces = 4;
        assertEquals(true,memorice.crearPersona( num, nVeces ));
    }
}
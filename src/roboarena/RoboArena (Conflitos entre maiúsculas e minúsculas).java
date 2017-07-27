package roboarena;

//import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Roboarena
  {

    public static void main(String[] args)
      {
        Arena a1 = new Arena();

        List<Robo> robos;

        a1.lerArquivo();

        try
          {
            Formatter arq = new Formatter("Resultado.txt");
            robos = a1.getRobos();
            System.out.println(a1.getRobos());
            if (robos != null)
              {
                for (Robo robo : robos)
                  {
                    arq.format("\n" + robo.toString() + "\n\n\n");

                  }
              }
            arq.close();

          } catch (FileNotFoundException ex)
          {
            Logger.getLogger(Roboarena.class.getName()).log(Level.SEVERE, null, ex);
          } finally
          {

          }

      }
  }

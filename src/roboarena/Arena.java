package roboarena;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arena
  {

    private String[][] arena;
    private List<Robo> robos;
    private int linI;
    private int colI;
    private char tipoLetra;

    public List<Robo> getRobos()
      {
        return robos;
      }

    public void setRobos(List<Robo> robos)
      {
        this.robos = robos;
      }

    public String[][] getArena()
      {
        return arena;
      }

    public void setArena(String[][] arena)
      {
        this.arena = arena;
      }

    public char getTipoLetra()
      {
        return tipoLetra;
      }

    public void setTipoLetra(char tipoLetra)
      {
        this.tipoLetra = tipoLetra;
      }

    public Arena()
      {
      }

    private void localizarInicio()
      {

        String loc = ""; //l,c
        String inicio = "LNOSlnos";

        for (int l = 0; l < this.arena.length; l++)
          {
            for (int c = 0; c < this.arena[l].length; c++)
              {
                if (inicio.contains(this.arena[l][c]))
                  {
                    loc = l + "," + c;
                    this.linI = l;
                    this.colI = c;
                    return;
                  }
              }
          }
      }

    public int[] getInicio()
      {
        return new int[]
          {
            linI, colI
          };
      }

    public char letraInicial()
      {

        String letraL = "Ll";
        String letraN = "Nn";
        String letraS = "Ss";
        String letraO = "Oo";

        for (int l = 0; l < this.arena.length; l++)
          {
            for (int c = 0; c < this.arena[l].length; c++)
              {
                if (letraL.contains(this.arena[l][c]))
                  {
                    return this.tipoLetra = 'L';
                  } else if (letraN.contains(this.arena[l][c]))
                  {
                    return this.tipoLetra = 'N';
                  } else if (letraS.contains(this.arena[l][c]))
                  {
                    return this.tipoLetra = 'S';
                  } else if (letraO.contains(this.arena[l][c]))
                  {
                    return this.tipoLetra = 'O';
                  }
              }
          }
        return 0;
      }

    public int getTipoDeLetra()
      {
        return tipoLetra;
      }

    public void lerArquivo()
      {
        FileInputStream file;
        String nomeRobo, movRobo, tipoRobo;
        Scanner scan;

        this.robos = new ArrayList<>();

        try
          {
            file = new FileInputStream("Entrada De Dados.txt");

            scan = new Scanner(file);

            int l = scan.nextInt();
            int c = scan.nextInt();

            this.arena = new String[l][c];

            String linha;
            scan.nextLine();

            for (int lin = 0; lin < l; lin++)
              {
                linha = scan.nextLine();
                this.arena[lin] = linha.split("");//quebra a palavra
//                for (int col = 0; col < c; col++) {
//                    this.arena[lin][col] = linha.charAt(col) + "";//retorna o caracter da posiçao x da linha + aspas converte para string
//                }
              }

            this.localizarInicio();
            this.letraInicial();
            //scan.nextLine();

            Robo r = null;
            while (scan.hasNext())
              {
                tipoRobo = scan.next();
                if (!"0".equals(tipoRobo))
                  {
                    nomeRobo = scan.next();
                    movRobo = scan.next();
                    if ("Jiban".equals(tipoRobo) || "jiban".equals(tipoRobo))
                      {
                        r = new Jiban(nomeRobo, movRobo, getTipoLetra());
                      } else if ("Jaspion".equals(tipoRobo) || "jaspion".equals(tipoRobo))
                      {
                        r = new Jaspion(nomeRobo, movRobo, getTipoLetra());
                      } else if ("Jiraia".equals(tipoRobo) || "jiraia".equals(tipoRobo))
                      {
                        r = new Jiraia(nomeRobo, movRobo, getTipoLetra());
                      }
                    r.setTpLetra(getTipoLetra());
                    r.rotacionar(this, this.tipoLetra);
                    this.robos.add(r);

                  }
              }

          } catch (FileNotFoundException ex)
          {
            Logger.getLogger(Arena.class.getName()).log(Level.SEVERE, null, ex);
          }

      }
  }

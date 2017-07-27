/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboarena;

/**
 *
 * @author
 */
public class Jiban extends Robo
  {

    private String[] mov;
    private String[][] matriz;
    private int moedas = 0;
    private int i = 0;
    private int n = 0;
    private int l;
    private int c;

    public String[] getMov()
      {
        return mov;
      }

    public void setMov(String[] mov)
      {
        this.mov = mov;
      }

    public int getI()
      {
        return i;
      }

    public void setI(int i)
      {
        this.i = i;
      }

    public Jiban(String nome, String movimento, char tpLetra)
      {
        super(nome, movimento, tpLetra);
      }

    @Override
    public char rotacionar(Arena a, char tpLetra)
      {

        this.matriz = a.getArena();

        if (this.n == 0)
          {
            this.l = a.getInicio()[0];
            this.c = a.getInicio()[1];
            this.setTpLetra(a.letraInicial());
          }

        for (this.i = this.n; this.i < getMovimento().length; this.i++)
          {
            this.n++;

            switch (this.getTpLetra())
              {

                case 'L':
                    //this.mov[this.i] = this.getMovimento()[this.i];
                    if ("Dd".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('S'); //retorna a sul
                        return rotacionar(a, getTpLetra());
                      } else if ("Ee".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('N');
                        return rotacionar(a, getTpLetra());
                      } else if ("Ff".contains(this.getMovimento()[this.i]))
                      {
                        if (this.c < a.getArena()[l].length - 1)
                          {
                            this.c++;
                            if ("Ff".contains(this.getMovimento()[this.i]) && "#".contains(a.getArena()[this.l][this.c]))
                              {
                                this.c--;
                              }
                            if ("$".contains(a.getArena()[this.l][this.c]))
                              {
                                this.matriz[this.l][this.c] = ".";
                                this.incrementaMoeda();
                                a.setArena(this.matriz);
                              }
                          }
                      }

                    break;

                case 'N':
                    if ("Dd".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('L'); //retorna a norte
                        return rotacionar(a, getTpLetra());
                      } else if ("Ee".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('O'); //retorna a sul
                        return rotacionar(a, getTpLetra());
                      } else if ("Ff".contains(this.getMovimento()[this.i]))
                      {
                        if (this.l > 0)
                          {
                            this.l--;
                            if ("Ff".contains(this.getMovimento()[this.i]) && "#".contains(a.getArena()[this.l][this.c]))
                              {
                                this.l++;
                              }
                            if ("$".contains(a.getArena()[this.l][this.c]))
                              {
                                this.matriz[this.l][this.c] = ".";
                                this.incrementaMoeda();
                                a.setArena(this.matriz);
                                //                          }
                              }
                          }
                      }
                    break;

                case 'S':
                    if ("Dd".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('O');
                        return rotacionar(a, getTpLetra());
                      } else if ("Ee".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('L'); //retorna a norte
                        return rotacionar(a, getTpLetra());
                      } else if ("Ff".contains(this.getMovimento()[this.i]))
                      {
                        if (this.l < a.getArena().length - 1)
                          {
                            this.l++;
                            if ("Ff".contains(this.getMovimento()[this.i]) && "#".contains(a.getArena()[this.l][this.c]))
                              {
                                this.l--;
                              }
                            if ("$".contains(a.getArena()[this.l][this.c]))
                              {
                                this.matriz[this.l][this.c] = ".";
                                this.incrementaMoeda();
                                a.setArena(this.matriz);
                              }
                            //                }
                          }
                      }
                    break;

                case 'O':
                    if ("Dd".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('N');
                        return rotacionar(a, getTpLetra());
                      } else if ("Ee".contains(this.getMovimento()[this.i]))
                      {
                        this.setTpLetra('S');//retorna a sul
                        return rotacionar(a, getTpLetra());
                      } else if ("Ff".contains(this.getMovimento()[this.i]))
                      {
                        if (this.c < a.getArena()[this.l].length - 1)
                          {
                            this.c--;
                            if ("Ff".contains(this.getMovimento()[this.i]) && "#".contains(a.getArena()[this.l][this.c]))
                              {
                                this.c++;
                              }
                            if ("$".contains(a.getArena()[this.l][this.c]))
                              {
                                this.matriz[this.l][this.c] = ".";
                                this.incrementaMoeda();
                                a.setArena(this.matriz);
                              }
                          }
                      }

                    break;

                default:
                    break;
              }
          }

        return 0;
      }

  }

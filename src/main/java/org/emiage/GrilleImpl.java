package main.java.org.emiage;

/**
 *
 * Implementation d'une grille.
 */
public class GrilleImpl implements Grille {

    /**
     * Grille de sudoku.
     */
    private final char[][] grille;

    /**
     * Constructeur.
     *
     * @param uneGrille Grille de sudoku
     */
    public GrilleImpl(final char[][] uneGrille) {
        this.grille = uneGrille;
    }

    /**
     * Accesseur de la propriété grille.
     *
     * @return char[][] grille
     */
    public final char[][] getGrille() {
        return grille;
    }

    /**
     * @return largeur/hauteur de la grille.
     */
    @Override
    public final int getDimension() {
        return this.getGrille().length;
    }

    /**
     * Affecte une valeur dans la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si la valeur est interdite aux vues des
     * autres valeurs de la grille
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     * ('1',...,'9')
     */
    @Override
    public final void setValue(final int x, final int y, final char value) {
        if (this.possible(x, y, value)) {
            String illegalArgMsg = "Valeur interdite aux vues des autres "
                    + "valeurs de la grille";
// Parcours de la ligne x et véfification de l'existence de la vauleur.
            for (int i = 0; i < this.getDimension(); i++) {
                if (this.grille[x][i] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }
// Parcours de la colonne y et véfification de l'existence de la vauleur.
            for (int j = 0; j < this.getDimension(); j++) {
                if (this.grille[j][y] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }
// Parcours de la box et véfification de l'existence de la vauleur.
            int tailleBloc = (int) Math.sqrt(this.getDimension());
            int i = (x / tailleBloc) * tailleBloc;
            int j = (y / tailleBloc) * tailleBloc;

            for (int k = 0; k < tailleBloc; k++) {
                for (int c = 0; c < tailleBloc; c++) {
                    if (this.grille[i + k][j + c] == value) {
                        throw new IllegalArgumentException(illegalArgMsg);
                    }
                }
            }
            this.grille[x][y] = value;
        }
    }

    /**
     * Recupere une valeur de la grille.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return valeur dans la case x,y
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
    @Override
    public final char getValue(final int x, final int y) {
//      si x ou y sont hors bornes (0-8).
        if (((x < 0) || (x >= this.getDimension()))
                || ((y < 0) || (y >= this.getDimension()))) {
            throw new IllegalArgumentException("Ligne ou colonne hors borne");
        }
        return this.grille[x][y];
    }

    /**
     * Test si une grille est terminee.
     *
     * @return true si la grille est complete
     */
    @Override
    public final boolean complete() {
//      Parcours des lignes et colonnes et vérification de l'existence
//      ou non d'une veleur EMPTY c'est à dire vide.
        boolean existe = true;
        for (int x = 0; x < this.getDimension(); x++) {
            for (int y = 0; y < this.getDimension(); y++) {
                if (this.grille[x][y] == Grille.EMPTY) {
                    existe = false;
                }
            }
        }
        return existe;
    }

    /**
     * Test si une valeur est possible dans la grille par rapport a ce qu'elle
     * contient deja.
     *
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @param value valeur a mettre dans la case
     * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throw IllegalArgumentException si value n'est pas un caractere autorise
     * ('1',...,'9',..)
     * @return boolean
     */
    @Override
    public final boolean possible(final int x, final int y, final char value) {
//      si x ou y sont hors bornes
        if ((x < 0 || x >= this.getDimension())
                || (y < 0 || y >= this.getDimension())) {
            throw new IllegalArgumentException("Ligne ou colonne hors borne");
        }
//       S'assurer que la valeur n'est pas interdite
        for (int i = 0; i < this.getDimension(); i++) {
            if (Grille.possible[i] == value) {
                return true;
            }
        }
        return false;
    }

}

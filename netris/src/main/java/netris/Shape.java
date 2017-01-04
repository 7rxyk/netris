package netris;

/**
 * Shape luokka: tarkoitus hoitaa NetrisPala-luokan palojen koordinaattien yms.
 * tarkempi alustus ja luoda Shape netrispala olio
 */
public final class Shape {

    public NetrisPalat muoto;
    public int koordinaatti[][];

    /**
     * Metodilla asetetaan parametrillä tuleva muoto Shape olion
     * koordinaatteihin
     *
     * @see kutsuu toista metodia asetaMuoto, jonka parametrinä asetettava muoto
     * menee.
     */
    public Shape() {
        koordinaatti = new int[4][2];
        asetaMuoto(NetrisPalat.Testi);
    }

    /**
     * Metodilla asetetaan parametrillä tuleva muoto Shape olion
     * koordinaatteihin
     *
     * @param muoto on Shape olioon asetettava NetrisPala muoto.
     */
    public void asetaMuoto(NetrisPalat muoto) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                koordinaatti[i][j] = muoto.koordinaatit[i][j];
            }
        }
        this.muoto = muoto;
    }

    private void setX(int index, int x) {
        koordinaatti[index][0] = x;
    }

    private void setY(int index, int y) {
        koordinaatti[index][1] = y;
    }

    /**
     * x metodi antaa index parametrinä olevan x koordinaatin
     *
     * @param index on toisen metodin tarjoama indeksi mistä x koordinaatti
     * halutaan
     * @return palauttaa shape olion sen hetkisen y koordinaatin
     */
    public int x(int index) {
        return koordinaatti[index][0];
    }

    /**
     * y metodi antaa index parametrinä olevan y koordinaatin
     *
     * @param index on toisen metodin tarjoama indeksi mistä x koordinaatti
     * halutaan
     * @return palauttaa shape olion sen hetkisen y koordinaatin
     */
    public int y(int index) {
        return koordinaatti[index][1];
    }

    public NetrisPalat getMuoto() {
        return muoto;
    }

    /**
     * Asetetaan palaksi random muoto
     *
     * @see Random-muoto asetetaan asetaMuoto metodikutsun parametriksi
     */
    public void setRandomMuoto() {
        asetaMuoto(NetrisPalat.getRandomPala());
    }

    /**
     * minX käy läpi shape olion koordinaatit ja palauttaa niistä pienimmän
     *
     * @return palauttaa shape oliolle pienimmän X koordinaatit
     */
    public int minX() {
        int m = koordinaatti[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, koordinaatti[i][0]);
        }
        return m;
    }

    /**
     * minY käy läpi shape olion koordinaatit ja palauttaa niistä pienimmän
     *
     * @return palauttaa shape oliolle pienimmän Y koordinaatit
     */
    public int minY() {
        int m = koordinaatti[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, koordinaatti[i][1]);
        }
        return m;
    }

    /**
     * Vasemmalle metodi reagoi toisen luokan käskyyn pyörittää Shape palaa
     * vasemmalle ja antaa palikalle uudet koordinaatit.
     *
     * @return palauttaa shape oliolle uudet koordinaatit
     */
    public Shape vasemmalle() {
        if (muoto == NetrisPalat.Nelio) {
            return this;
        }
        Shape tulos = new Shape();
        tulos.muoto = muoto;
        for (int i = 0; i < 4; ++i) {
            tulos.setX(i, y(i));
            tulos.setY(i, -x(i));
        }
        return tulos;
    }

    /**
     * Oikealle metodi reagoi toisen luokan käskyyn pyörittää Shape palaa
     * oikealle ja antaa palikalle uudet koordinaatit.
     *
     * @return palauttaa shape oliolle uudet koordinaatit
     */
    public Shape oikealle() {
        if (muoto == NetrisPalat.Nelio) {
            return this;
        }
        Shape tulos = new Shape();
        tulos.muoto = muoto;
        for (int i = 0; i < 4; ++i) {
            tulos.setX(i, -y(i));
            tulos.setY(i, x(i));
        }
        return tulos;
    }
}

package netris.Keyboard;

import netris.netrisGUI.Netris;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import netris.NetrisPalat;
import netris.Pelilauta;

public class TAdapter extends KeyAdapter {

    public Pelilauta peli;

    /**
     * keyPressed metodi toimii välikätenä käyttäjän näppäimistö syötteen ja
     * niistä tapahtuvien toimintojen välillä. Todennäköisesti muutoksia
     * tarvitaan, kun ei välttämättä toimi tällä hetkellä.
     *
     * @param painallus on käyttäjän antama syöte näppäimistöllään, jonka mukaan
     * pelissä toimitaan
     */
    @Override
    public void keyPressed(KeyEvent painallus) {
        peli = new Pelilauta(new Netris());
        if (!peli.paalla || peli.nykyinenPalikka.getMuoto() == NetrisPalat.Testi) {
            return;
        }
        int keycode = painallus.getKeyCode();
        if (keycode == 'p' || keycode == 'P') {
            peli.pause();
            return;
        }
        if (peli.tauolla) {
            return;
        }
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                peli.liikuta(peli.nykyinenPalikka, peli.nykyinenX - 1, peli.nykyinenY);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("right");
                peli.liikuta(peli.nykyinenPalikka, peli.nykyinenX + 1, peli.nykyinenY);
                break;
            case KeyEvent.VK_DOWN:
                peli.liikuta(peli.nykyinenPalikka.oikealle(), peli.nykyinenX, peli.nykyinenY);
                break;
            case KeyEvent.VK_UP:
                peli.liikuta(peli.nykyinenPalikka.vasemmalle(), peli.nykyinenX, peli.nykyinenY);
                break;
            case KeyEvent.VK_SPACE:
                peli.pudota();
                break;
            case 'd':
                peli.taysiRivi();
                break;
            case 'D':
                peli.taysiRivi();
                break;
        }
    }
}

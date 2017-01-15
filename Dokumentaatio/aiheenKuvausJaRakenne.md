Aihe: Tetris, palikkapeli, jossa eri muotoiset palikat putoilee peliruudun yläosasta ja tavoitteena on saada täysiä rivejä aikaiseksi. Pelaaja saa pisteitä aina, kun rivi tulee täyteen ja se katoaa pelialueelta.

Käyttäjät: Pelaaja

Toiminnot:

S painikkeella peli alkaa.
Pelin alettua palikoita alkaa putoilla ja käyttäjä voi tietyillä pyörittää palikoita haluamaansa asentoon (ylänuoli) ja liikuttaa vasemmalla tai oikealla nuolinäppäimellä niitä peliruudun alueella.
Pause eli p painike pistää pelin tauolle.

Netris pelin rakenne:

Pelin aloitus tapahtuu Main-luokan kautta, joka kutsuu uutta Netrispeliä. Netrisluokka on yhteydessä TAdapter-luokkaan, jolla se hoitaa näppäinkomennot pelin tiimellyksessä. Netris-luokka on lisäksi yhteydessä Game-luokkaan, jossa hoidetaan pelin logiikka ja eri metodikutsut Board-luokkaan.  Board-Luokan tehtävänä on hoitaa osan pelin toiminnallisuudesta, kuten pisteinen lasku, rivien poistoa jne. Board-luokasta on yhteys BoardCell-luokkaan, joka on käytännössä pelialustana toimia 2d array. BoardCell-luokasta yhteys Shape-luokkaan, jossa hoidetaan netrispala-kohtainen toiminnallisuus ja tästä luokasta on yhteys NetrisPieces luokkaan, joka on käytännössä vain kunkin palatyypin koordinaattien ja värien säilöntä enumina.


![Alt text](/Dokumentaatio/UusinLuokkis.png "Luokkakaavio Netriksestä")


![Alt text](/Dokumentaatio/Netrisplaying.png "Netrispeluu yleisesti")


![Alt text](/Dokumentaatio/pieceRotation.png "Palan pyöritys")


![Alt text](/Dokumentaatio/Pausegame.png "Pelin pausettaminen")



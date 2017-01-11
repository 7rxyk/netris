Aihe: Tetris, palikkapeli, jossa eri muotoiset palikat putoilee peliruudun yläosasta ja tavoitteena on saada täysiä rivejä aikaiseksi. Pelaaja saa pisteitä aina, kun rivi tulee täyteen ja se katoaa pelialueelta.

Käyttäjät: Pelaaja

Toiminnot:

Alkuun peliin voisi tulla start nappula, joka aloittaa pelin.
Pelin alettua palikoita alkaa putoilla ja käyttäjä voi tietyillä pyörittää palikoita haluamaansa asentoon ja liikuttaa vasemmalla tai oikealla nuolinäppäimellä niitä peliruudun alueella.
Myös joku lopeta peli nappula voisi olla hyvä, yleensä kyllästyy ennen kuin häviää ja pause

Netris pelin rakenne:

Pelin aloitus tapahtuu Main-luokan kautta, joka kutsuu uutta Netrispeliä. Netrisluokka on yhteydessä Board-luokkaan sekä TAdapter-luokan kautta, että suoraan. Board-luokan konstruktori kutsuu uutta Netrispeliä. TAdapter on käyttäjän antamien näppäimistökomentojen vastaanottaja ja ohjaa luokan kautta pyynnöt toisten luokkien metodeille suorittaa käyttäjän haluama tehtävä. Board-Luokan tehtävänä on hoitaa grafiikan ja pelin start ja pause toiminnallisuus. Board-luokasta on yhteys Game-luokkaan, jonne on laitettu suurin osa pelin logiikasta, eli palojen siirrot, täysien rivien tarkistus jne. Game-luokasta yhteys Shape-luokkaan, jossa hoidetaan netrispala-kohtainen toiminnallisuus ja tästä luokasta on yhteys NetrisPieces luokkaan, joka on käytännössä vain kunkin palatyypin koordinaattien ja värien säilöntä enumina.


![Alt text](/Dokumentaatio/UusinLuokkis.png "Luokkakaavio Netriksestä")


![Alt text](/Dokumentaatio/Netrisplaying.png "Netrispeluu yleisesti")


![Alt text](/Dokumentaatio/pieceRotation.png "Palan pyöritys")


![Alt text](/Dokumentaatio/Pausegame.png "Pelin pausettaminen")



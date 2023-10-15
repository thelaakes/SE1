author: lneft2s

Aufgaben aus dem WS23/24 im Kurs SE1

## Aufgabe 1-1
•_Wie kann diese Kommunikationsverbindung nun dennoch mit Hilfe einer zusätzlichen
Klasse, welche die dazu notwendige Objekt-Erzeugung übernimmt, aufgebaut
werden? In welchem Package sollte diese zusätzliche Klasse liegen? Bitte beachten
Sie dabei auch die Hinweise bzw. Anforderungen aus den Kommentaren der
Klassen, Methoden und des Interfaces._<br>
- Eine Factory Klasse kann die Objekterzeugung übernehmen.
- Die Klasse sollte im Package control liegen, da Sie eine Kontrollfunktion übernimmt.

• _Welches Entwurfsmuster (engl.: design pattern) könnte für die Problematik der
Objekt-Erzeugung verwendet werden? Was ist der software-technische Nutzen bei
der Verwendung des Entwurfsmusters? Gratistipp: Hinweise für das korrekte Pattern
finden sie bei unten angegeben Video-Tutorien ;-)_<br>
- Factory Pattern
- Der softwaretechnische Nutzen liegt in der Wartbarkeit, Lesbarkeit und Erweiterbarkeit des Codes. 
Dadurch muss bspw. der Code für die TranslatorFactory nur an einem Punkt im Projekt geändert aber kann von jeder andere Klasse verwendet werden.

• _Wie muss man den Source Code des Interface ggf. anpassen, um mögliche
auftretende Kompilierfehler zu beseitigen?_
- Das Interface muss public sein
## Aufgabe 1-3
• _Was ist der Vorteil einer separaten Test-Klasse?_ <br>

- Trennung von Test- und Produktionscode
- Übersichtlichkeit durch Trennung des Codes
- Code kann wieder verwendet werden

• _Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?_ <br>
- Durch Äquivalenzklassen werden die Testfälle kategeorisiert, dadurch reduziert sich der Aufwand, da für jede Äquivalenzklasse nur ein Test durchgeführt werden muss.
- Außerdem werden dadurch alle möglichen Fälle abgedeckt, sowohl bei erwarteten als auch unerwarteten Eingaben. Auch Grenzfälle werden abgedeckt.<br>

• _Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar
durchführbar?_
- Die Klasse erzeugt ein Objekt der Klasse GermanTranslator
- Durch diese konkrete Instanziierung ist es schwierig die Klasse zu testen


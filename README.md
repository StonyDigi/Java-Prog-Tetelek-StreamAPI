# Java-Prog-Tetelek-StreamAPI

PROJEKT VERZIÓKÖVETÉSÉNEK FOLYAMATA, MENETE!

Felhasználói adatok beállítása (név, email):
git config --global user.name "Teszt Elek"
git config --global user.email "tesztelek@teszt.hu"

Felhasználói adatok lekérése:
git config user.name
git config user.email

Git inicializálása a projektben(itt vesszük használatba és létrehozzuk a mappánkon belüli rejtett .git fájlok fa struktúráját, mappáit):
git init

Git gyűjtemény sztátuszának ellenőrzése (tájékoztat az utoljára létrehozott/módosított fájlokról/mappákról, megmutatja az "untracked files-okat" a még nem követett fájlokat!)
git status

Fájlok hozzáadása a staging area-hoz, gyűjteményhez:
git add index.html (egyesével)
git add *html (vagy mindegyiket ami .html kiterjesztésű hozzáad!)
git add. (ez pedig minden fájlt hozzáad a gyűjteményhez még a txt-is , de azt nem akarom menteni, követni a gyűjteményben!)

Fájlok kivétele a staging area-ból (ha véletlenül hozzáadtam a txt filet):
git rm --cached 'elérési út'

Nem támogatott fájlok listázása(amiket nem akarunk feltölteni a gyűjteménybe):
.gitIgnore fájlban történik meg : meg tudjuk adni ebben a fájlban, hogy melyik azok a fájlok (akár név szerint, akár kiterjesztés szerint)
, amelyeket nem szeretném követni!

Verzió rögzítése(változások elmentése):
git commit -m "üzenet" : eddigi változások rögzítése egy verzióban (mindenképp szükséges, mert így lesz visszakövethető a varziók közötti változások)

ÁGAK KEZELÉSE (BRANCH-EK):
(Magamnak leágazok, Független lesz a MAIN branch-től, de ugyan az és nem fogom tudni felülírni a fő production branchet!!!)
- Ág létrehozása : git branch ágnév
- Ágra váltás : git checkout ágnév
- Ág összefésülése : git merge ágnév (abból az ágból indítjuk mindig a merge-t amelyiket meg akarjuk tartani!!! jelen esetben a maint, attól még létezik a teszt ág, hogy belefésültem a mainbe)
(ha úgy gondolom, hogy jó lett a kódom amit írtam a main leágba akkor össze tudom fésülni a fő branch-el, iránnyal!!)
- Ág törlése : git branch -d ágnév
(törlöm a teszt ágat, mert összefésültem a main-el!!)

(Ha egy ágon módosítunk, hozzáadunk vagy commitolunk, akkor a többi ág azt nem látja, csak a korábbi változtatásokhoz fér hozzá.
Ezeket az ágakat össze kell fésülni, ha elkészültünk a munkával -> ilyenkor fognak kiderülni az ütközések.
Ha más is dolgozik egy adott ágon és történik valami változás az online repositoryban(távoli gyűjteményben),
akkor az automatikusan nem fog szinkronizálódni, ezt nekünk kell manuálisan megtennünk.)


GITHUB online felületén, bejelentkezem és létrehozok egy új repo-t a lokális main branchem-nek és hozzá adom a távoli szerverhez!
(Távoli gyűjtemény megadása)
git remote add origin git@github.com:StonyDigi/FrontendFirstRepo.git
(Feltöltés a gyűjteménybe)
git push -u origin main

Távoli gyűjteményből letöltés helyi gyűjteménybe:
git pull git@github.com:StonyDigi/FrontendFirstRepo.git

Gyűjtemény visszaállítása a legutóbbi pull állapotra (commitok megmaradnak és pusholni is lehet őket):
(véletlenül kitörlöm még a lomtárból is)
git reset --hard

Gyűjtemény (visszaállítása) az egyel korábbi verzióra:
git reset --hard HEAD~1 (eggyel korábbi verzió visszaállítása, és így tudunk lépkedni a verziók között)


#fájlok ignorálása
*.txt
*.doc
*.docx
*.pdf

Legutóbbi verzió (visszavonása, még egyel korábbi verzió visszaállítása csak vissza vonja a rögzítést nem áll vissza az egész):
git reset --soft HEAD~1


(…or push an existing repository from the command line)
git remote add origin git@github.com:StonyDigi/aaaaaa.git
git branch -M main
git push -u origin main

git clone git@github.com:szabopeter92/git-vizsga0104.git


# Családi TO-DO LIST    
## Tartalom jegyzék   
  * feladat funkcionális követelményei
  * feladat nem funkcionális követelményei
  * szakterületi fogalomjegyzék (azon fogalmak definiálása, ami köré az alkalmazás épül)
  * szerepkörök    
### Feladat funkcionális követelményei   
*Nyújtandó szolgáltatások ismertetése:*   

* *Családtagként* szeretnék felvenni egy feladatot a napi teendők listámra. Ebben az esetben a feladat egyedi és csakis én végezhetem el. (Feladatok felvétele) 
* *Családtagként* szeretném megtekinteni, hogy milyen feladatok szerepelnek a listámon. (Feladatok listázása) 
* *Családtagként* szeretnék törölni egy feladatot a listámról, ami már teljesítve lett. (Feladatok elvégzése) 
* *Családtagként* szeretnék megjegyzést fűzni a feladataimhoz. (Feladatoz tartozó megjegyzés)
 <br/>  

* *Családfőként* szeretném látni a családtagok lisáit, beleértve az enyémet is. (Feladatok listázása) 
* *Családfőként* szeretnék felvenni egy feladatot a napi teendők listámra. Ebben az esetben a feladat egyedi és csakis én végezhetem el. (Feladatok felvétele) 
* *Családfőként* szeretnék kiosztani egy családi-feladatot, ami az összes családtag listáján szerepel, illetve bárki elégezheti. 
* *Családfőként* szeretnék kiosztani egyedi feladatot, ami egy adott családtag listáján szerepel és csakis ő végezheti el. 
* *Családfőként* szeretnék törölni egy feladatot a listámról, ami már teljesítve lett. (Feladatok elvégzése) 
* *Családfőként* szeretnék megjegyzést fűzni a családi-feladatokhoz. (Feladatoz tartozó megjegyzés)
* *Családfőként* szeretnék megjegyzést fűzni a feladataimhoz. (Feladatoz tartozó megjegyzés)    
<br/> 

* A főoldalon lehet majd bejelentkezni, emellett alkalmazás ismertetése is szerepelni fog. 
* A bejelentkezésnél fog eldőlni, hogy a felhasznaló családfőként, vagy csaladtagként kíván bejeletkezni/regisztrálni.   
  
### Feladat nem funkcionális követelményei   
  
* Felhasználóbarát, ergonomikus elrendezés és kinézet. 
* Gyors működés. 
* Biztonságos működés: jelszavak tárolása, funkciókhoz való hozzáférés.   

### Szerepkörök   

* jogosultsági csoportok
* elérhető funkciók
   

**Vendég**: a főoldal tartalmához fér hozzá, feladatot rögzíteni nem tud.  
**Családtag**: a vendég szerepkörén túl feladatot tud felvenni, törölni(teljesíteni), megjegyzést tud fűzni a feladatokhoz illetve képes megtekinteni őket.  
**Családfő**: a családtag szerepkörén túl az összes feladatot meg tudja tekinteni. Képes egyedi és családi feladatok kiosztására, illetve ezekhez tartozó megjegyzést írni.    
  
### Szakterületi fogalomjegyzék     
  
 **TO-DO LIST**: Teendők listája, minden felhasználohoz (legyen az családtag vagy családfő) tartozik egy lista.   
 **Feladat teljesítése**: A feladat eltávolítása a teendők lisájáról.   
 **Egyedi feladat**: Olyan feladat, amelyet csak az adott családtag teljesíthet.   
 **Családi feladat**: Olyan "közös" feladat, amelyet a család bármelyik tagja teljesíthet.  
 
 ### Végpontok bemutatása 
 
* GET /tasks : megadja a Task-okat
* GET /tasks/id/descriptions : megadja egy Task-hoz lévő Description-oket
* GET /familys : megadja a Family-ket
* GET /familys/id/users : megadja egy Family-het tartozó User-eket
* GET /users : megadja a User-eket
* GET /users/id/tasks : megadja egy User-hez tartozó Task-okat
* GET /descriptions : megadja a Description-oket
* POST /tasks : Új Task létrehozása
* POST /tasks/id/descriptions : egy Task-hoz új Description létrehozása
* POST /familys : Új Family létrehozása
* POST /familys/id/users : egy Family-hez új User hozzáadása
* POST /users : Új User létrehozása
* POST /users/id/tasks : egy User-hez új Task hozzáadása
* POST /descriptions : Új Description létrehozása 
* POST /users/login : Felhasználó bejelentkezése 
* POST /users/register : Felhasználó regisztrálása
* PUT /tasks/id : egy Task szerkesztése
* PUT /familys/id : egy Family szerkesztése
* PUT /users/id : egy User szerkesztése
* PUT /users/id/tasks : egy User-hez tartozó Task szerkesztése
* PUT /descriptions/id : egy Description szerkesztése
* DELETE /tasks/id : Egy Task törlése
* DELETE /familys/id : egy Family törlése
* DELETE /users/id : egy User törlése
* DELETE /descriptions/id : egy Description törlése 

### Használati esetek diagram

![HasznalatiEsetek](https://user-images.githubusercontent.com/48122593/70378310-1974ff80-191f-11ea-9b57-38337f2bada4.jpg)

### Adatbázis diagram 

![Database](https://user-images.githubusercontent.com/48122593/70378346-6fe23e00-191f-11ea-9482-84bbccdc8331.jpg)

### Fejlesztői környezet bemutatása 

## Backend 
* A backend Apache NetBeans IDE 11.1 segítségével készült, spring boot technológia felhasználásával. 
## Frontend 
* A frontend Visual Studio Code segítségével készult, angular keretrendszer felhasználásával. Ezen kívül természetesen használva volt a HTML, CSS, JavaScript. 

### Az alkalmazott könyvtárstruktúra bemutatása 

## Backend 
![strukturanetbeans](https://user-images.githubusercontent.com/48122593/70378568-33fca800-1922-11ea-8d34-a0a8423bfdcd.PNG)
## Frontend 
![vscodestruktura1](https://user-images.githubusercontent.com/48122593/70378572-365f0200-1922-11ea-8802-54a28194e984.PNG)
![vscodestruktura2](https://user-images.githubusercontent.com/48122593/70378575-37902f00-1922-11ea-88ce-833f79e4c5c5.PNG)

### Kliensoldali szolgáltatások listája 

* **Bejelentkezés** : Bejelentkezés, adminként vagy sima userkéent
* **Feladat lista megtekintése** : Feladat lista megtekintése kiegészítve további információkkal
* **Feladat lista bővítése/szűkítése** : Új feladat felvéteve, feladat módosítása, feladat kiosztása(admin eseten), feladat elvégzése(törése)
* **Kijelentkezés**  




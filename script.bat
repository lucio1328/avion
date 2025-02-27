@echo off

REM Declaration des variables
    set nom_projet=avion
    set temp=D:\Lucio\S5-S6\MrNaina\avion\test
    set bin=D:\Lucio\S5-S6\MrNaina\avion\bin
    set web=D:\Lucio\S5-S6\MrNaina\avion\web
    set xml=D:\Lucio\S5-S6\MrNaina\avion\web.xml
    set lib=D:\Lucio\S5-S6\MrNaina\avion\lib
    set war=.\
    set src=D:\Lucio\S5-S6\MrNaina\avion\src

REM Suppression de temp si il existe
    rmdir /s /q %temp%

REM Creation du nouveau temp
    mkdir %temp%
    REM Creation du sous-repertoire temp/WEB-INF/lib
        mkdir %temp%"\WEB-INF\lib"
    REM Creation du sous-repertoire temp/WEB-INF/classes
        mkdir %temp%"\WEB-INF\classes"

REM Copie des web de notre espace de travail initial vers le repertoire temporaire temp
    xcopy /s /e /q %web% %temp%

REM Copie du web.xml de notre espace de travail initial vers temp/WEB-INF/
    copy %xml% %temp%"\WEB-INF\"

REM Copie des *.jar de notre espace de travail initial ver temp/WEB-INF/lib
    xcopy /s /e /q %lib% %temp%"\WEB-INF\lib"

REM compilation du code source
    @REM javac %src%\*.java -d %temp%"\WEB-INF\classes"
    xcopy /s /e /q %bin% %temp%"\WEB-INF\classes"

REM Convertir le repertoire temp en .war
    jar -cf %nom_projet%.war -C %temp% .

    rmdir /s /q %temp%

REM Copie du fichier war vers tomcat/webapps
    xcopy /y %nom_projet%.war "D:\Lucio\logiciel\tomcat\webapps"

REM Supprimer le fichier WAR temporaire
    del %nom_projet%.war
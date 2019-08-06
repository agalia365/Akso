@echo off
if $%1==$?       goto help
if $%1==$/?      goto help
if $%2==$DRV     set  GRDRIVE=%1
if $%2==$DRV     goto end
if $%2==$drv     set  GRDRIVE=%1
if $%2==$drv     goto end
rem
rem **** Change here for Installation in different Location ****
rem **** set GRDRIVE=X:\FABI -> Installation in  X:\FABI\GR ****
set GRDRIVE=c:
rem **** end Change ****
rem
set $P$=%GRDRIVE%\GR
if .%GRDRIVE%==. goto err1
if .%1==.        goto err2
if $%2==$NEW     goto grinst
if $%2==$new     goto grinst
if not exist %$P$%\%1\EXE\*.EXE goto err2
rem
:grprog
set  GRTOOLS=%$P$%\TOOLS
set   GRPROG=%$P$%\%1
set  GLOTEXT=%GRPROG%\TEXT
set   GLOERR=%GRPROG%\ERR
set   GLODAT=%GRPROG%\DAT
if  .%GRTEST%==. set GRDPATH=%PATH%
set   GRTEST=ON
rem
     %GRDRIVE%
cd   %GRPROG%
path %GRPROG%\EXE;%GRTOOLS%;%GRDPATH%
rem
if not .%GRONLINE%==. goto end
if not exist %GRTOOLS%\ALT_SERV.COM goto end
%GRTOOLS%\ALT_SERV
%GRTOOLS%\NOTICE  %GLOERR%\notice.txt
%GRTOOLS%\SCRFILE %GLOERR%\scrfile.txt
if not errorlevel 1 SET GRONLINE=ON
goto end
rem
:grinst
if exist %$P$%\TOOLS\*.* goto grinst1
md %$P$%
md %$P$%\TOOLS
rem
:grinst1
md %$P$%\%1
md %$P$%\%1\DAT
md %$P$%\%1\ERR
md %$P$%\%1\EXE
md %$P$%\%1\HELP
md %$P$%\%1\TEXT
goto end
rem
:err1
echo -
echo Fehler:  "GRDRIVE=LAUFWERK" fehlt   im Environment, z.B. "GRDRIVE=C:"
echo Error :  "GRDRIVE=DRIVE"    missing in Environment, e.g. "GRDRIVE=C:"
echo schreibe "SET GRDRIVE=X:"   in AUTOEXEC.BAT (Dos) oder gib "LOAD X: DRV" ein
echo include  "SET GRDRIVE=X:"   in AUTOEXEC.BAT (Dos) or  type "LOAD X: DRV"
goto help
rem
:err2
echo -
echo Fehler: %$P$%\%1 ist ein ungueltiges Verzeichnis
echo Error : %$P$%\%1 is an invalid Directory
echo Verzeichnis fehlt oder Programm nicht gefunden
echo Directory missing or Program not found
rem
:help
echo -
echo "LOAD LAUFWERK    DRV" stellt den Laufwerksbuchstaben ein
echo "LOAD DRIVE       DRV" sets the Drivename
echo "LOAD VERZEICHNIS NEW" richtet eine neue Programmversion ein
echo "LOAD DIRECTORY   NEW" prepares a new Program Version
echo "LOAD VERZEICHNIS"     laedt eine installierte Programmversion
echo "LOAD DIRECTORY"       loads an installed Program Version
echo -
echo Beispiele/Examples:
echo -
echo "LOAD C: DRV"          stellt "GRDRIVE" auf "C:" ein
echo "LOAD C: DRV"          sets   "GRDRIVE" to  "C:"
echo "LOAD TWIN NEW"        erzeugt Verzeichnisse fuer Version "TWIN"
echo "LOAD TWIN NEW"        creates Directories   for  Version "TWIN"
echo "LOAD TWIN"            laedt Version "TWIN"  in     "C:\GR\TWIN"
echo "LOAD TWIN"            loads Version "TWIN"  in     "C:\GR\TWIN"
rem
:end
set $P$=
echo.
echo Important!
echo ----------
echo first close the communication to DICU with BF0, then close grtest-program with Q
echo.

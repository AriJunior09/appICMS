@echo off

set "autor=Ari Junior"
set "versao=1.0"

echo Criado por: %autor%
echo Versao: %versao%

:menu
echo -------------------------------------------
echo    CALCULADORA DE SUBSTITUICAO TRIBUTARIA
echo -------------------------------------------
java App
pause
goto menu
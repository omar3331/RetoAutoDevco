# RetoAutoDevco

_Este proyecto hace referencia a la automatización de la página web travelocity, la cual contiene diferentes escenarios que prueban los componetes de la pagina y validan la reacción que tendrian con la interacción del usuario. Este proyecto se crea con el patrón de diseño Screenplay._

Inicialmente se debe clonar el repositorio, en una carpeta en el equipo local, cuando se encuentre en el equipo se ejecuta la lista de comandos de windows o CMD, en esta se hubica en la carpeta donde esta el proyecto y se ejecuta como se describe a continuación.

### Para realizar la ejecución de todos los escenarios, desde consola, se hubica en la carpeta que contiene el proyecto, y se utiliza el siguiente comando:
	
	* gradle clean test aggregate -i

### Para realizar la ejecución de uno o mas escenarios, desde consola, se hubica en la carpeta que contiene el proyecto, y se utiliza el siguiente comando:

	* gradle clean test --tests *nombre del runner a ejecutar* aggregate -i

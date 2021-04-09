## Diagrama de Clases
```mermaid

Title "Diagrama de clases de FAMSO"
interface FAMSO_CA
abstract class FAMSO
abstract class SoFAMSO
abstract class AssetFAMSO

FAMSO <|-- Pagina_Principal
FAMSO <|-- SoFAMSO
SoFAMSO <|-- ApkFAMSO
FAMSO_CA <|.. SoFAMSO
SoFAMSO <|-- AssetFAMSO
AssetFAMSO <|-- WebCAFAMSO

class FAMSO {
+ public preloadContenidoPrincipal(Bundle bundle)
}

class SoFAMSO {
+ public preloadSerevicios(Bundle bundle)
}

class ApkFAMSO {
+ public loadVistaFormularioReserva(Bundle bundle)
}

class AssetFAMSO {
+ public loadConfirmacionReservaTurno(Bundle bundle)
}
@enduml
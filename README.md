# QA Automation Demo – Selenium + API (RestAssured)

## 📌 Objetivo del proyecto

Este repositorio tiene como objetivo demostrar **criterio profesional en QA Automation**, más allá de simplemente ejecutar tests.

El foco está puesto en:

* Buenas prácticas de diseño
* Separación de responsabilidades
* Tests mantenibles y legibles
* Automatización Web + API

El proyecto está pensado como **portfolio técnico**, ejecutable localmente y portable (sin dependencias externas complejas).

---

## 🧱 Stack tecnológico

* **Java 17**
* **Maven** (gestión de dependencias y ejecución)
* **Selenium WebDriver** (automatización Web)
* **TestNG** (framework de testing)
* **RestAssured** (automatización de APIs REST)
* **Allure** (reportes de ejecución)

---

## 🧩 Arquitectura general

El proyecto sigue una arquitectura simple pero profesional:

```
Test
 ↓
Page Objects / Flows
 ↓
API Clients (simulan capa de datos)
 ↓
Backend / Servicio REST
```

### Principios aplicados

* Single Responsibility Principle (SRP)
* Separation of Concerns
* Código legible > código "ingenioso"

---

## 🧪 Testing Web

La automatización Web se basa en **Page Object Model (POM)**:

* Los **Page Objects** contienen:

    * Localizadores
    * Acciones de la página
    * Validaciones propias de la UI

* Los **Tests**:

    * Orquestan escenarios
    * No contienen lógica de UI

Las esperas explícitas (`WebDriverWait`) se manejan dentro de las páginas para evitar flakiness.

---

## 🌐 Testing de APIs

Las pruebas de API se implementan utilizando **RestAssured**, con el objetivo de:

* Validar endpoints REST
* Preparar datos para escenarios de UI
* Simular acceso a datos

Los tests de API están desacoplados de la UI y pueden ejecutarse de forma independiente.

---

## 🔗 Integración UI + API

Además de pruebas aisladas, el proyecto incluye **un flujo de integración Web + API**, por ejemplo:

* Obtener datos (credenciales / estado / entidades) vía API
* Utilizar esa información en un flujo automatizado de UI

Esto representa escenarios reales donde QA Automation valida **sistemas completos**, no solo pantallas.

---

## 🗄️ Nota sobre acceso a Base de Datos (DAO / DTO)

En proyectos productivos, utilizo una arquitectura basada en:

* **DAO (Data Access Object)** para encapsular queries
* **DTO (Data Transfer Object)** para mapear resultados a objetos de dominio

Esto permite:

* Evitar SQL en los tests
* Mejorar mantenibilidad
* Trabajar con datos tipados

👉 **En este proyecto, la capa de datos se simula mediante APIs REST**, ya que:

* Mantiene el proyecto portable
* Evita dependencias externas
* Facilita la ejecución local y en CI

La API cumple el rol conceptual de la capa DAO.

---

## 📊 Reportes

Los resultados de ejecución se visualizan mediante **Allure Reports**, permitiendo:

* Ver resultados por ui
* Evidenciar fallos
* Mostrar pasos ejecutados

---

## ▶️ Ejecución

```bash
mvn clean ui
```

Para visualizar el reporte Allure:

```bash
allure serve
```

---

## 🚀 Estado del proyecto

🔧 En desarrollo

Este README se irá completando a medida que se agreguen:

* Tests de API
* Flujos de integración
* Reportes avanzados

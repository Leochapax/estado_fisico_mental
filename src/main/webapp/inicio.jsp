<%-- 
    Document   : inicio
    Created on : 10/09/2025, 2:52:41 p. m.
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Estado fisico y Mental</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }

    header {
      background-color: #002147;
      color: white;
      display: flex;
      align-items: center;
      padding: 0.5rem 1rem;
      justify-content: space-between;
    }

    .menu-icon {
      font-size: 2rem;
      cursor: pointer;
    }

    .logo img {
      height: 70px;
    }

    .login-area {
      display: flex;
      align-items: center;
      gap: 0.5rem;
    }

    .login-area input {
      padding: 0.3rem 0.5rem;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    .login-area button {
      padding: 0.4rem 0.8rem;
      font-weight: bold;
      border: none;
      cursor: pointer;
      border-radius: 3px;
    }

    .login-area .ingresar {
      background-color: #e74c3c;
      color: white;
    }

    .login-area .registrarse {
      background-color: #e74c3c;
      color: white;
    }

    .login-area a {
      color: #e74c3c;
      font-size: 0.85rem;
      margin-left: 0.5rem;
      text-decoration: none;
    }

    .banner {
      background-image: url('imagenes/images.jpg');
      background-size: cover;
      background-position: center;
      background-repeat: no-repeat;
      height: 400px;
      display: flex;
      justify-content: center;
      align-items: center;
      text-align: center;
      color: white;
    }

    .banner h1 {
      font-size: 2.8rem;
      background-color: rgba(0, 0, 0, 0.5);
      padding: 1rem 2rem;
      border-radius: 10px;
    }

    .contenido {
      display: grid;
      grid-template-columns: 1fr 1fr 1fr;
      gap: 1rem;
      padding: 2rem;
    }

    .bloque {
      background-color: white;
      padding: 1rem;
      border-radius: 8px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    .bloque img {
      width: 100%;
      height: auto;
    }

    .bloque button {
      margin-top: 1rem;
      padding: 0.5rem 1rem;
      background-color: #c0392b;
      color: white;
      border: none;
      border-radius: 4px;
      font-weight: bold;
      cursor: pointer;
    }

    @media (max-width: 768px) {
      .contenido {
        grid-template-columns: 1fr;
      }

      .login-area {
        flex-direction: column;
        align-items: flex-end;
      }
    }
  </style>
   <script>
            function redirectToInicioSesion() {
                window.location.href = "inicio_sesion.jsp";
            }
        </script>
</head>
<body>

  <header>
    <!-- Botón Menú Hamburguesa -->
    <div class="menu-icon" onclick="window.location.href='menu.jsp'">☰</div>
    
    <!-- Logo -->
    <div class="logo">
      <img src="imagenes/Logo_Estado.jpg" alt="Logo">
    </div>
    
    <!-- Botones -->
    <div class="login-area">
      <input type="text" placeholder="USUARIO">
      <input type="password" placeholder="CONTRASEÑA">
      <button class="ingresar" onclick="window.location.href='login.jsp'">INGRESAR</button>
      <button class="registrarse" onclick="window.location.href='registro.jsp'">REGISTRARSE</button>
      <a href="recuperar.jsp">Recuperar Contraseña</a>
    </div>
  </header>

  <!-- Banner -->
  <section class="banner"></section>

  <!-- Contenido -->
  <section class="contenido">
    <div class="bloque">
      <img src="imagenes/saludmental.jpg" alt="Salud física y mental">
    </div>
    <div class="bloque" style="background-color:#002147; color:white;">
      <p>
        Entra al mundo de la energía y la salud con el ejercicio, directrices nutricionales y más con una amplia variedad de actividades.
      </p>
      <button onclick="window.location.href='inicio_sesion.jsp'">INICIO</button>
    </div>
    <div class="bloque">
      <img src="imagenes/socializar.jpg" alt="Ejercicio físico">
    </div>
  </section>

</body>
</html>


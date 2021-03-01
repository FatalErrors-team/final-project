import { Link } from "react-router-dom";
import "./style.css";

function NavBar() {
  function logout() {
    localStorage.clear();
    window.location.href = "http://localhost:3000/autenticacao";
  }

  return (
    <div className="navbar-container">
      <ul className="link-container">
        <li>
          <Link to="/">HOME</Link>
        </li>
        <li>
          <Link to="/cadastro-de-alunos">CADASTRAR ALUNO</Link>
        </li>
        <li>LISTA DE ALUNOS</li>
      </ul>
      <div className="usuario__container">
        <p id="usuario">Olá, João Victor. </p>
        <a onClick={logout}>Logout</a>
      </div>
    </div>
  );
}

export default NavBar;

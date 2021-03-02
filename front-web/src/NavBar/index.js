import { NavLink } from "react-router-dom";
import { ReactComponent as LogoutIcon } from "./logout.svg";
import "./style.css";

function NavBar({ administrador }) {

	function logout() {
		localStorage.clear();
		window.location.href = "http://localhost:3000/autenticacao";
	}

	return (
		<div className="navbar">
			<div className="navbar__container">
				<ul className="link__container">
					<li>
						<NavLink to="/" exact>Início</NavLink>
					</li>
					<li>
						<NavLink to="/cadastro-de-alunos">Cadastro</NavLink>
					</li>
					<li>
						<a href="/#lista-de-alunos">Lista de Alunos</a>
					</li>
				</ul>
				<div className="usuario__container">
					<p id="usuario">Olá, { administrador.nomeCompleto } </p>
					<button onClick={logout}>Sair <LogoutIcon style={{ fill: "white", verticalAlign: "middle" }} /></button>
				</div>
			</div>
		</div>
	);
}

export default NavBar;

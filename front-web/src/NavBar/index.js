import { Link } from 'react-router-dom'
import './style.css'

function NavBar(){
    return(
        <div className="navbar-container">
            <ul className="link-container">
                <li><Link to="/">HOME</Link></li>
                <li><Link to="/cadastro-de-alunos">CADASTRAR ALUNO</Link></li>
                <li>LISTA DE ALUNOS</li>
            </ul>
        </div>
    )
}

export default NavBar;
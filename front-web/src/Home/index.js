import { Link } from 'react-router-dom';
import StudentList from '../StudentList'
import { ReactComponent as MainImage } from './MainImage.svg'
import './style.css'
function Home(){
    return(
        <div className="home-container">
            <div className="home-content">
                <div className="description-container">
                    <h1 className="main-text">Home Studies</h1>
                    <h2 className="secondary-text">Fatalerrors</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur </p>
                    <p>adipiscing elit, sed do eiusmod tempor </p>
                    <p>incididunt ut labore et dolore magna aliqua. </p>
                    <p>Lorem ipsum dolor sit amet, consectetur </p>
                    <p>adipiscing elit, sed do eiusmod tempor </p>
                </div>
                <MainImage className="main-image" />

            </div>
            <Link to="/cadastro-de-alunos"><button className="home-btn">CADASTRAR NOVO ALUNO</button></Link>
            
            <StudentList />
        </div>
    )
}
export default Home;
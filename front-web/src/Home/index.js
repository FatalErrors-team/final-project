import StudentList from "../StudentList";
import { Link } from "react-router-dom";
import axios from "axios";
import { ReactComponent as MainImage } from "./MainImage.svg";
import "./style.css";
import { useState, useEffect } from "react";

function Home() {
	const [estudantes, setEstudantes] = useState([]);

	async function obterAlunos(setEstudantes) {
		const response = await axios({
			method: "GET",
			url: "https://boiling-river-79785.herokuapp.com/alunos",
			headers: {
				"Content-Type": "application/json",
				Authorization: localStorage.getItem("token"),
			},
		});
		if (response.status === 200) {
			setEstudantes(response.data.data);
		}
	}


	useEffect(() => {
		obterAlunos(setEstudantes);
	}, []);

	return (
		<div className="home__container">
			<div className="home__content">
				<div className="description__container">
					<h1 className="main-text">Gama Alunos</h1>
					<h2 className="secondary-text">Fatalerrors</h2>
					<p>A Gama Alunos é sua plataforma preferida</p>
					<p>de gerenciamento de alunos. Somos realmente</p>
					<p>completo! Temos desde funções mais simples</p>
					<p>a um time completamente disposto a dar</p>
					<p>suporte 24 horas. </p>
				</div>
				<MainImage className="main-image" />
			</div>
			<Link to="/cadastro-de-alunos">
				<button className="home-btn">Cadastrar Novo Aluno</button>
			</Link>
			<StudentList estudantes={estudantes} funcaoAtualizar={obterAlunos} setEstudantes={setEstudantes} />
		</div>
	);
}
export default Home;

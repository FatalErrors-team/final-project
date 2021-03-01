import StudentList from "../StudentList";
import { Link } from "react-router-dom";
import axios from "axios";
import { ReactComponent as MainImage } from "./MainImage.svg";
import "./style.css";
import { useState, useEffect } from "react";

async function obterAlunos(setEstudantes) {
  const response = await axios({
    method: "GET",
    url: "http://localhost:8080/alunos",
    headers: {
      "Content-Type": "application/json",
      Authorization: localStorage.getItem("token"),
    },
  });
  if (response.status === 200) {
    setEstudantes(response.data.data);
  } else {
    console.log({ status: false, text: "Houve algum erro!" });
  }
}

function Home() {
  const [estudantes, setEstudantes] = useState([]);

  useEffect(() => {
    obterAlunos(setEstudantes);
  }, []);

  return (
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
      <Link to="/cadastro-de-alunos">
        <button className="home-btn">CADASTRAR NOVO ALUNO</button>
      </Link>
      <StudentList estudantes={estudantes} />
    </div>
  );
}
export default Home;

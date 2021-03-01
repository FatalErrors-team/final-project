import StudentList from "../StudentList";
import axios from 'axios';
import { ReactComponent as MainImage } from "./MainImage.svg";
import "./style.css";
function Home() {
  localStorage.setItem("token", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvIjoiYnVkaW5oYSJ9.xRP1O67djDGd4Qv1nGLuSyW4GtQQk006ZHUHtFqGiSo");
  function obterEstudantes() {
    axios({
      method: 'GET',
      url: 'http://localhost:8080/alunos',
      headers: {
        "Content-Type": "application/json",
        Authorization: localStorage.getItem("token")
      }})
      .then((response) => {
        if (response.status === 200) {
          console.log(response.data);
        } else {
          console.log({ status: false, text: "Houve algum erro!" });
        }
      })
      .catch(() => {
        console.log({ status: false, text: "Houve algum erro!" });
      });
  }

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
      <button className="home-btn">CADASTRAR NOVO ALUNO</button>

      <StudentList estudantes={obterEstudantes()}/>
    </div>
  );
}
export default Home;

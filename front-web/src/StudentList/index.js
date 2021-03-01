import Card from "./Card";

import "./style.css";

function StudentList({ estudantes }) {
  return (
    <div className="list-container">
      {(estudantes === []) ||
      <div className="card-main-description">
        <h3>Não há alunos cadastrados.</h3>
      </div> }
      {estudantes.map((estudante) => {
        return <Card nome={estudante.nome} curso={estudante.curso} conceito={estudante.conceito} />
      })}
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
      <Card nome="Nome" curso="Curso" conceito="Conceito" />
    </div>
  );
}

export default StudentList;

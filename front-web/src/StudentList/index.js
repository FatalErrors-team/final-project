import Card from "./Card";

import "./style.css";

function StudentList({ estudantes }) {
  return (
    <div className="list-container">
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

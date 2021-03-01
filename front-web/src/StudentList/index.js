import Card from "./Card";

import "./style.css";

function StudentList({ estudantes }) {
  return (
    <div className="list-container">
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

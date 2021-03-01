import Card from "./Card";

import "./style.css";

function StudentList({ estudantes }) {
  return (
    <div className="list-container">
      {(estudantes === []) ??
      <div className="card-main-description">
        <h3>Não há alunos cadastrados.</h3>
      </div> }
      {estudantes.map((estudante) => {
        return <Card estudante={estudante} />
      })}
    </div>
  );
}

export default StudentList;

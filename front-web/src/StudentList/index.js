import Card from "./Card";

import "./style.css";

function StudentList({ estudantes, funcaoAtualizar, setEstudantes }) {
	return (
		<div id="lista-de-alunos" className="student__container">
			{estudantes === [] 
				? 
					<div className="list empty">
						Nenhum aluno cadastrado ainda!
					</div>
				: 
					<div className="list filled">
						{estudantes.map((estudante) => {
							
							return <Card estudante={estudante} key={estudante.id} funcaoAtualizar={funcaoAtualizar} setEstudantes={setEstudantes}/>
						})}
					</div>
			}
		</div>
	);
}

export default StudentList;

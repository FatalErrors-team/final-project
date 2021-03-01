import { useState } from "react";
import "./style.css";

function Card({ nome, curso, conceito }) {
  const [hidden, setHidden] = useState(false);

  const toogleDescription = () => {
    if (hidden) {
      setHidden(false);
    } else {
      setHidden(true);
    }
  }
  return (
    <>
      <div className="card-main-description">
        <h3>nome</h3>
        <h3>curso</h3>
        <h3>conceito</h3>
        <button className="card-btn" onClick={toogleDescription}>{hidden ? "MOSTRAR MENOS" : "MOSTRAR MAIS"}</button>
      </div>
      { hidden ?
        <div className="complementar-description">
          <div className="complementar-description-row">
            <h3>Nota Prova 1</h3>
            <h3>7.5</h3>
          </div>
          <div className="complementar-description-row">
            <h3>Nota Prova 2</h3>
            <h3>7.5</h3>
          </div>
          <div className="complementar-description-row">
            <h3>Nota Apresentaçao</h3>
            <h3>7.5</h3>
          </div>
          <div className="total-text">
            <h3>TOTAL</h3>
            <h3>7.5</h3>
          </div>
          <button className="btn-exclude">EXCLUIR</button>
          <button className="btn-update">EDITAR</button>
        </div>
        : ''}
    </>
  )

}
export default Card;
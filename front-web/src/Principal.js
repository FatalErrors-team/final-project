import Home from "./Home";
import NavBar from "./NavBar";
import Footer from "./Footer";
import { useEffect, useState } from "react";
import { Route, Switch } from "react-router-dom";
import axios from "axios";
import FormPage from "./FormPage/FormPage";
import FormPageAtualizar from "./FormPageAtualizar/FormPageAtualizar";


async function obterAdministrador(setAdministrador) {
	const response = await axios({
		method: "GET",
		url: "https://boiling-river-79785.herokuapp.com/administrador",
		headers: {
			Authorization: localStorage.getItem("token")
		}
	});
	if (response.status === 200) {
		setAdministrador(response.data.data);
	}
}



function Principal() {

	const [administrador, setAdministrador] = useState({});

	useEffect(() => {
		obterAdministrador(setAdministrador);
	}, []);

	return (
		<>
      <NavBar administrador={administrador}/>
      <Switch>
				<Route path="/atualizar-aluno/:id">
					<FormPageAtualizar />
				</Route>
				<Route path="/cadastro-de-alunos">
          <FormPage />
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>
      <Footer />
    </>
  );
}

export default Principal;

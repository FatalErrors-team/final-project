import Home from "./Home";
import NavBar from "./NavBar";
import Footer from "./Footer";
import { Route, Switch } from "react-router-dom";
import FormPage from "./FormPage/FormPage";

function Principal() {
  return (
    <>
      <NavBar />
      <Switch>
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
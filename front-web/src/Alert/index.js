
import { useState, useEffect } from "react";
import "./style.css";

function Alert({ texto, tempo, link }) {

	let sum = 0;
	const [paintedWidth, setPaintedWidth] = useState(0);
	const [opacityProp, setOpacityProp] = useState(0);

	useEffect(() => {
		function timer() {
			if (sum === 0) {
				setOpacityProp(1);
			}
			sum += tempo/20000;
			setPaintedWidth(sum);
			if (sum < 100) {
				setTimeout(timer, tempo/1000)
			} else {
				setOpacityProp(0);
			}
		}
		if (sum < 100) {
			timer();
		}
	}, [sum]);

	return (
		<a href={(link) ? link : "#"}>
			<div className="alert__container" style={{ opacity: opacityProp }}>
				<div className="alert__text">
					{ texto }
				</div>
				<div className="alert__progress">
					<div className="loading" style={{ width: paintedWidth+"%" }}></div>
				</div>
			</div>		
		</a>
	)
}

export default Alert;

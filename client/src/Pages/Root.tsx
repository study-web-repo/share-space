import { Outlet } from 'react-router-dom';
import Header from '../Common/Header';

const Root = () => {
	return (
		<>
			<Header />
			<Outlet />
		</>
	);
};

export default Root;

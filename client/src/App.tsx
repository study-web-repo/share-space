import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import './App.css';
import './index.css';
import DetailView from './Pages/DetailView';
import Home from './Pages/Home';
import ListView from './Pages/ListView';
import NotFound from './Pages/NotFound';
import Root from './Pages/Root';
const router = createBrowserRouter([
	{
		path: '/',
		element: <Root />,
		errorElement: <NotFound />,
		children: [
			{ index: true, element: <Home /> },
			{ path: '/list', element: <ListView /> },
			{ path: '/list/:listID', element: <DetailView /> },
		],
	},
]);

function App() {
	return <RouterProvider router={router} />;
}

export default App;

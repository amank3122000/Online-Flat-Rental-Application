import App from './App';
import ReactDOM from 'react-dom';

test('Renders without crashing', () => {
  const div =document.createElement('div');
  ReactDOM.render(<App />,div);
  ReactDOM.unmountComponentAtNode(div);
});

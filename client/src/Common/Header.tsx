const Header = () => {
	return (
		<>
			<div className="p-3.5 border-b border-zinc-100 ">
				<div className="flex items-center justify-between px-8">
					<h1 className="text-5xl">airspace</h1>
					<input
						className="p-5 rounded-3xl w-72 bg-zinc-100 h-9"
						placeholder="지역, 공간유형, 공간명으로 찾아보세요"
					></input>
					<div>
						<button className="w-44"> 당신의 공간을 공유하세요</button>
						<button></button>
					</div>
				</div>
			</div>
		</>
	);
};

export default Header;

#include <iostream>
#include <vector>
#include <algorithm>

int main(int argc, char* argv[]) {	
	std::vector<std::string> arguments(argv, argv + argc);
	for(int i = 0; i < argc; i++) {
		std::string s{argv[i]};
		std::reverse(s.begin(), s.end());
		std::cout << s << std::endl;
	}
}
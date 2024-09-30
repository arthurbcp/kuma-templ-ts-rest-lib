
import { AxiosRequestConfig } from "axios";
import { User } from "../../dto/user";
import HttpProvider from "../../providers/http/http_provider";

export class RepositoriesService {
  private provider: HttpProvider;

  constructor(http: HttpProvider) {
    this.provider = http;
  }
  // List repositories of the authenticated user
  public getRepositories(data: {
    query: any;
    params: any;
    config: AxiosRequestConfig;
  }): Promise<AxiosResponse<any>> {
    return this.provider.request<>("/repositories/{id}", data);
  }
}
  // Create a new repository
  public CreateRepository(data: {
    query: any;
    params: any;
    data: NewRepository;
    config: AxiosRequestConfig;
  }): Promise<AxiosResponse<any>> {
    return this.provider.request<>("/repositories/{id}", data);
  }
}
  // Get details of a specific repository
  public getRepositoryById(data: {
    query: any;
    params: any;
    config: AxiosRequestConfig;
  }): Promise<AxiosResponse<any>> {
    return this.provider.request<>("/repositories/{id}", data);
  }
}
  // Update an existing repository
  public updateRepositoryById(data: {
    query: any;
    params: any;
    data: UpdateRepository;
    config: AxiosRequestConfig;
  }): Promise<AxiosResponse<any>> {
    return this.provider.request<>("/repositories/{id}", data);
  }
}
  // Delete a repository
  public deleteRepositoryById(data: {
    query: any;
    params: any;
    config: AxiosRequestConfig;
  }): Promise<AxiosResponse<any>> {
    return this.provider.request<>("/repositories/{id}", data);
  }
}